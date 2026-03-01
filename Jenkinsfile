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

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t saucedemo-tests .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run --rm saucedemo-tests'
            }
        }
    }
}
