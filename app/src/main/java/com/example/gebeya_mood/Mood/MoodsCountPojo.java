package com.example.gebeya_mood.Mood;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoodsCountPojo implements Serializable
{

@SerializedName("Happy")
@Expose
private Integer happy;
@SerializedName("Content")
@Expose
private Integer content;
@SerializedName("Neutral")
@Expose
private Integer neutral;
@SerializedName("Sad")
@Expose
private Integer sad;
@SerializedName("Angry")
@Expose
private Integer angry;
private final static long serialVersionUID = 2140604992385041545L;

public Integer getHappy() {
return happy;
}

public void setHappy(Integer happy) {
this.happy = happy;
}

public MoodsCountPojo withHappy(Integer happy) {
this.happy = happy;
return this;
}

public Integer getContent() {
return content;
}

public void setContent(Integer content) {
this.content = content;
}

public MoodsCountPojo withContent(Integer content) {
this.content = content;
return this;
}

public Integer getNeutral() {
return neutral;
}

public void setNeutral(Integer neutral) {
this.neutral = neutral;
}

public MoodsCountPojo withNeutral(Integer neutral) {
this.neutral = neutral;
return this;
}

public Integer getSad() {
return sad;
}

public void setSad(Integer sad) {
this.sad = sad;
}

public MoodsCountPojo withSad(Integer sad) {
this.sad = sad;
return this;
}

public Integer getAngry() {
return angry;
}

public void setAngry(Integer angry) {
this.angry = angry;
}

public MoodsCountPojo withAngry(Integer angry) {
this.angry = angry;
return this;
}

}