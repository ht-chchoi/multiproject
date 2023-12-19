pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
  }
  environment {
    targetProject = $TARGET_PROJECT
    projectPath = ''
    projectName = ''
    version_value = ''
    version = ''
  }
  stages {
    stage('prepare build argument') {
      steps {
        script {
          projectPath = targetProject.replaceAll(":", "/")
          sh "echo Project path: $projectPath"
          version_value = sh(returnStdout: true, script: "cat build.gradle.kts | grep -o 'version = [^,]*'").trim()
          sh "echo Project in version value: $version_value"
          version = version_value.split(/=/)[1].trim().split(/"/)[1].trim()
          sh "echo final version: $version"
        }
      }
    }
  }
}