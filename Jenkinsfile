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
        }
}