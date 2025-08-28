def call(String Project, String ImageTag String dockerhubuser){
withCredentials([usernamePassword(credentialsId: 'dockerhubcred', usernameVariable: 'dockerhubuser', passwordVariable: 'dockerhubpass')]) {
                sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
                sh "docker image tag notes-app:latest ${env.dockerhubuser}/notes-app:latest"
}
                sh "docker push ${env.dockerhubuser}/notes-app:latest"
}

