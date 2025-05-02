Check the commit history for incremental progress.

1. Monolithic(https://github.com/ankanchanda/job-listing-monolithic) to Microservice Conversion
2. Inter-service Communication
3. Service Registry - Eureka
4. Open feign - get rid of rest template
5. Observability using zipkin and micrometer
6. Config Server - for managing configurations - used https://github.com/ankanchanda/application-config
7. Gateway integration for single point of communication
8. Resilience4j - CircuitBreaking, Fallback, Retry, Rate Limiting
9. Message Queues
10. Packaging your file using jar, we can add dependency with the help of packaging tag but default will be jar
11. Dockerizing the microservices
	`./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<dockerhub-username>/<your-image-name>"`
    	`./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=ankanchanda/service-registry"`
        check the images at `docker image`
        to push the image in dockerhub `docker push <dockerhub-username>/<your-image-name>`
12. Kubernetes k8s
	Worker Nodes: Machines that run the application
	Kubelet: agent for Managing the node and communication with control plane
	Pods: Smallest and simplest unit for the kubernetes that you can create and deploy. Represents running process in cluster.
	Cluster: set of nodes to run containerized applications, they have pods, which contains multiple containers
	Container Runtime: for execution

	Control Plane: controls the state of cluster
	API Server: interface between control plane and rest of clusters
	ETCD: Distributed Key-Value store that holds the cluster's persistency, store configuration information.
	Scheduler: Places the pods in worker nodes based on resource availability. Responsible for distibuting work in the containers across multiple nodes.
