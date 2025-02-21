pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'prabhav49/scientific-calculator:latest'
        DOCKER_USER = credentials('docker-hub-credentials').username
        DOCKER_PASS = credentials('docker-hub-credentials').password
    }

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
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker login -u "$DOCKER_USER" -p "$DOCKER_PASS"'
            }
        }

        stage('Run Application') {
            steps {
                sh 'docker run --rm $DOCKER_IMAGE 1'
            }
        }
    }

    post {
        success {
            emailext(
                to: 'iam49smith@gmail.com',
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build was <b>successful!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        failure {
            emailext(
                to: 'iam49smith@gmail.com',
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build <b>failed!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        always {
            cleanWs()
        }
    }
}
