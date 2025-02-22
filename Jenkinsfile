pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'prabhav49/scientific-calculator:latest'
        ANSIBLE_PLAYBOOK = 'deploy.yml'
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
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    def deployStatus = sh(script: 'ansible-playbook --connection=local --become deploy.yml', returnStatus: true)
                    if (deployStatus != 0) {
                        error "Deployment failed!"
                    }
                }
            }
        }

    }

    post {
        success {
            emailext(
                to: 'iam49smith@gmail.com',
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build and deployment were <b>successful!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        failure {
            emailext(
                to: 'iam49smith@gmail.com',
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>The build or deployment <b>failed!</b></p>
                         <p>Check the build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>"""
            )
        }
        always {
            cleanWs()
        }
    }
}
