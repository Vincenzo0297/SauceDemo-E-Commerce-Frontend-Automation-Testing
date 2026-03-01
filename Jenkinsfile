pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn -B clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test -Dtest=TC1_SauceDemo'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}
