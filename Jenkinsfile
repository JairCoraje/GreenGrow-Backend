pipeline {
    agent any
    tools { 
        maven 'Maven_Jenkins'  
    }
	
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Maven_Jenkins') {
                    bat 'mvn clean compile'
                }
            }
        }


        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Maven_Jenkins') {
                    bat 'mvn test'
                }
            }
        }
    }
}
