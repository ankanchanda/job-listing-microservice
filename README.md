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
11. Dockerizing the microservices<br>
	`./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<dockerhub-username>/<your-image-name>"`<br>
    	`./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=ankanchanda/service-registry"`<br>
        check the images at `docker image`<br>
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
	
	kubectl: to interact with minikube. `kubectl cluster-info`
	
	Pod: A group of one or more containers and their shared resources such as volumes, IP Address and Network Ports.
		Container within a pod run on the same worker node and share the same lifecycle
		Pods are ephemeral and can be created, scheduled and destroyed dynamically.
		
	Pod is not: 
		- a durable entity
		- designed for horizontal scaling on their own. Can be achieved by creating multiple identical pods and distributing load among them
		- designed to be stateless
		- communicate with each other within the same cluster using localhost
		- Pods are assigned a unique IP Address within the cluster
	
	Key Considerations
	- Lifecycle and availability of pods are managed by kubernetes
	- Pods can have associated labels and annotations

	Service: A service in kubernetes is an abstraction that defines alogical set of Pods and a policy by which to access them, sometimes called a micro-service. In short, a way to access the pods
	
	Why do we need it? Pods in Kubernetes are ephemeral, they can be created and destroyed anytime, not reliable. Need service for persistent connection.

	Types of Service:
	- ClusterIP (default): it gives service its own ip-address to communicate with other services within the same cluster.
	- NodePort: Expands on clusterIP, exposes the service on same port across each node, makes it accessible outside the cluster using, using node-ip and node-port
	- LoadBalancer: exposes the service externally using the cloud providers load balancer. think it of as, it builds on node port and assigns a fixed external ip to a service, used i cloud based environments where load balancer can be provisioned automatically.
	
	Replica Set: A kubernetes object used for manageing and scaling a set of identical pdo replicas.
	
	Why do you need identical Pods? High Availability, Load Balancing, Scaling, Rolling updates, Service Discovery

	Replica Set is not
		- not designed to handle rolling updates or deployments, only focuses on desired number o replicas
		- doesn't provide declarative updates to the pods, it manages

	Deployments: manages the replicaset and provide updates for pods and replicasets. pods and replicasets donot change, rollout and updates are managed by deployments, you only have to define the state of the object and the deployment controller changes the actual state to the desired state at a control rate. 
	

