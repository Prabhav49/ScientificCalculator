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
                        body: """<p>The build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> has failed.</p>
                                 <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                        recipientProviders: [developers()],
                        to: 'iam49smith@gmail.com'
                    )
                }
            }
        }
    }
}
