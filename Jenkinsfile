pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'M3'
    }

    environment {
        DOCKER_IMAGE = "laamyr/devops_project"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    env.PATH = "/usr/local/bin:${env.PATH}"
                }
                sh '/usr/local/bin/docker build -t $DOCKER_IMAGE:latest .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    env.PATH = "/usr/local/bin:${env.PATH}"
                }
                withCredentials([usernamePassword(
                    credentialsId: '631badad-db2c-466e-9628-120a3768556c',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | /usr/local/bin/docker login -u $DOCKER_USER --password-stdin'
                    sh '/usr/local/bin/docker push $DOCKER_IMAGE:latest'
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    env.PATH = "/usr/local/bin:${env.PATH}"
                }
                withCredentials([file(credentialsId: 'kubeconfig-credentials', variable: 'KUBECONFIG')]) {
                    sh '''
                        /usr/local/bin/kubectl apply -f mysql-deployment.yaml -n devops
                        /usr/local/bin/kubectl apply -f spring-deployment.yaml -n devops
                        /usr/local/bin/kubectl rollout status deployment/spring-app -n devops --timeout=5m
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}