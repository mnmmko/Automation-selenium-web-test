pipeline{
    agent any
   
        stages{
            stage('Git Main Branch'){
                steps{
                    git branch:'main',url:'https://github.com/mnmmko/Automation-selenium-web-test'
                }
            }
            stage('Build'){
                steps{
                    bat 'mvn clean test -Dbrowser=chrome'
                }
            }
            stage('Test'){
                steps{
                    sh 'mvn test'
                }
            }
            stage('Report'){
                steps{
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
         post {
                always {
                    echo 'Pipeline finished!'
                }
                failure {
                    echo 'Build failed ❌'
                }
                success {
                    echo 'Build passed ✅'
                }
            }
}