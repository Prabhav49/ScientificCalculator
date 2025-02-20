pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Prabhav49/ScientificCalculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                failure {
                    emailext(
                        subject: "Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                        body: """<p><b>Build Failed:</b> ${env.JOB_NAME} #${env.BUILD_NUMBER}</p>
                                 <p>Click <a href="${env.BUILD_URL}">here</a> to view details.</p>""",
                        to: 'iam49smith@gmail.com'
                    )
                }
            }
        }
    }
}

