pipeline {
  agent any
  stages {
     stage('Lint & Unit Test') {
      parallel {                                
        stage('checkStyle') {
          steps {
            // We use checkstyle gradle plugin to perform this
            sh 'sudo ./gradlew checkStyle'
          }
        }
        stage('Unit Test') {
          steps {
            // Execute your Unit Test
            sh 'sudo ./gradlew testStagingDebug'
          }
        }
      }
    }
    stage('build') {
      steps {
        echo 'Meraf\'s development pipeline'
      }
    }
  }
}