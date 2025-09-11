pipeline{
    agent any
    environment {
            JIRA_SITE = 'https://mnabehqa.atlassian.net'
            JIRA_ISSUE = 'SCRUM-1'
        }
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
            stage('Update Jira') {
                        steps {
                            script {
                                jiraAddComment idOrKey: env.JIRA_ISSUE, comment: "Build #${env.BUILD_NUMBER} finished with status: ${currentBuild.currentResult}"
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
                          script {
                              jiraAddComment idOrKey: env.JIRA_ISSUE, comment: "Build passed ✅ – see report: ${env.BUILD_URL}"
                          }
                      }
            }
}