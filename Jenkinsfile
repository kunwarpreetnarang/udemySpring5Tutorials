pipeline {
    agent any
    stages {
        stage('--- Clean and compile project ---') {
            steps {
                //
                bat "mvn clean"
            }
        }
        stage('--- Run Test Cases ---') {
            steps {
                //
                bat "mvn test"
            }
        }
        stage('--- Deploy Project package ---') {
            steps {
                //
                bat "mvn package"
            }
        }
    }
}