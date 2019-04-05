node {
   stage("Code Check out"){
       git 'https://github.com/VanceaV/Admin.git'
   }
   stage("Compile-Package"){
       sh script: 'mvn clean install'
   }
   
   
   stage ("SonarQube-Analysys"){
        withSonarQubeEnv("sonorQube"){
            
             sh script: 'mvn sonar:sonar'
        }
   }
   
   stage("Quality Gate Check"){
          timeout(time: 1, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }        
}
