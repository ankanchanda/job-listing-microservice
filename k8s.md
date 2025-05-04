# Kubernetes

To create a pod with filename: `some-pod.yaml`
```
apiVersion: v1
kind: Pod
metadata:
	name: my-pod
spec:
	containers:
		- name: nginx
	 	  image: nginx:1.14.2
	  	  ports:
	  		- containerPort: 80
```

- To create the pod, navigate to directory, run `kubectl apply -f some-pod.yaml` (-f to specify the file name) 
- We cannot modify the pod with the same name, `my-pod` in the above case
- `kubectl get pods` to get all pods running
- `kubectl get pods -w` will open in watch mode with live status updates

To create a service with filename: `some-service.yaml`
```
apiVersion: v1
kind: Service
metadata:
	name: my-service
spec:
	selector:
		app: MyApp
	ports:
		- protocol: TCP
		  port: 80
		  targetPort: 9376
	
```
- To create the pod, navigate to directory, run `kubectl apply -f some-pod.yaml`
- `kubectl get srvice` to get all services running
- To specify a type, use `type: LoadBalancer` under spec

