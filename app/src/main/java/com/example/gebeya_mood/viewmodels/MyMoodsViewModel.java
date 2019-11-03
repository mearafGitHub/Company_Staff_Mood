
package com.example.gebeya_mood.viewmodels;

import android.app.Application;

        import androidx.annotation.NonNull;
        import androidx.lifecycle.AndroidViewModel;
        import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gebeya_mood.models.UserMood;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodTransformer;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;

public class MyMoodsViewModel extends ViewModel {
    public Retrofit retrofit;
    public UserMoodDao dao;
    public MutableLiveData<List<UserMood>> moods;


    public MyMoodsViewModel() {
        moods = new MutableLiveData<>(new ArrayList<>());


    }

    private void loadUserMoods(String userId, String user_team){
        List<UserMood> moodsDb = dao.getAll();
        if (moodsDb.isEmpty()){
           // MyMoodsFromApi();
        }
        else{
            moods.setValue(moodsDb);
        }

    }

    private void getMyMoodsFromApi(String userId, String user_team){

        UserMoodApiService userMoodApiService = retrofit.create(UserMoodApiService.class);
        userMoodApiService.getMoods().enqueue(new Callback<List<UserMoodsDto>>() {
            @Override
            public void onResponse(Call<List<UserMoodsDto>> call, Response<List<UserMoodsDto>> response) {
                List<UserMood> moodsApi = UserMoodTransformer.ListDtoToMood(response.body());
                dao.addMoods(moodsApi);
                moods.setValue(moodsApi);
            }

            @Override
            public void onFailure(Call<List<UserMoodsDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<UserMood>> getMoods(){
        return moods;
    }
}
