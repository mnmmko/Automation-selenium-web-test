pipeline{
    agent any
    environment {
                JIRA_SITE = 'MyJira'
                JIRA_ISSUE = 'PRO-123'
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
                              jiraComment(
                                  issueKey: env.JIRA_ISSUE,
                                  comment: "🚀 Jenkins Build #${env.BUILD_NUMBER} started"
                              )
                          }
                        }

            }
          stage('test jire site'){
            steps{
                script{
                    def sites = com.atlassian.jira.jenkins.JiraSite.getSites()
                      for (s in sites) {
                          echo '👉 Jira Site: ${s.name} | URL: ${s.url}'
                      }

                }
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
                                jiraComment(
                                    issueKey: env.JIRA_ISSUE,
                                    comment: "✅ Jenkins Build #${env.BUILD_NUMBER} finished successfully"
                                )
                            }
                        }
            }
}