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
          timeout(time: 4, unit: 'SECONDS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      } 
   
    dir('target') {
        stage("Archive"){
         archiveArtifacts '*.jar'
        }
    }
   
   
   stage('Upload to S3') {

        dir('/var/lib/jenkins/workspace/PiplineJob_1'){

            pwd(); //Log current directory

            withAWS(region:'us-east-1',credentials:'JenkinsCred') {

                 def identity=awsIdentity();//Log AWS credentials

                // Upload files from working directory 'dist' in your project workspace
                s3Upload(bucket:"vladimirvancea", workingDir:'target', includePathPattern:'**/*.jar');
            }

        };
    }
   
   
   
    
}
