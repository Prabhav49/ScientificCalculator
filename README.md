# Scientific Calculator with DevOps

A Java-based Scientific Calculator with complete DevOps implementation including CI/CD pipeline setup, containerization, and automated deployment.

## Overview

This project implements a command-line scientific calculator in Java with a comprehensive DevOps pipeline including:
- Version control with Git/GitHub
- Build automation with Maven
- Unit testing with JUnit
- Continuous Integration with Jenkins
- Containerization with Docker
- Image registry using Docker Hub
- Deployment automation with Ansible

## Technologies Used

- **Java:** Programming language for the calculator implementation
- **Maven:** Build automation and dependency management
- **JUnit:** Unit testing framework
- **Git/GitHub:** Version control and source code management
- **Jenkins:** CI/CD automation server
- **Docker:** Containerization platform
- **Docker Hub:** Container image registry
- **Ansible:** Configuration management and deployment automation

## Project Structure

```
ScientificCalculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Main.java  # Main calculator logic
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   └── MainTest.java  # Test cases
├── Jenkinsfile  # Jenkins pipeline configuration
├── Dockerfile  # Docker container configuration
├── docker-compose.yml  # Container orchestration
├── deploy.yml  # Ansible playbook for deployment
├── inventory  # Ansible inventory configuration
└── pom.xml  # Maven project configuration
```

## Setup Instructions

### Prerequisites

Make sure you have the following tools installed on your system:

```bash
sudo apt update
sudo apt install git maven jenkins docker.io ansible openjdk-17-jdk -y
```

### Jenkins Setup

1. Start the Jenkins service:
   ```bash
   sudo systemctl enable jenkins
   sudo systemctl start jenkins
   ```

2. Required Jenkins Plugins:
    - Email Notification
    - Pipeline Stage View Plugin
    - Docker Plugin
    - Docker Pipeline
    - Docker-build-step
    - Ansible Plugin
    - Ansible Tower Plugin
    - SSH Agent Plugin
    - SSH Pipeline Steps
    - SSH Plugin

### Docker Hub Configuration

1. Create a Docker Hub account at [https://hub.docker.com/](https://hub.docker.com/)
2. Add Docker Hub credentials to Jenkins:
    - Navigate to "Manage Jenkins" > "Security" > "Credentials"
    - Click on "Stores scoped to Jenkins" > "global"
    - Click "Add Credentials"
    - Add your Docker Hub username and password with ID `docker-hub-credentials`

### Running the CI/CD Pipeline

1. Create a new Jenkins Pipeline job
2. Configure the job to use "Pipeline script from SCM"
3. Select Git as the SCM
4. Enter the repository URL: `https://github.com/Prabhav49/ScientificCalculator.git`
5. Specify the branch name (e.g., `master`)
6. Set the script path to `Jenkinsfile`
7. Click "Save" and run the pipeline with "Build Now"

## Pipeline Stages

The Jenkins pipeline includes the following stages:

1. **Clone Repository:** Fetches the source code from GitHub
2. **Build:** Compiles the Java code using Maven
3. **Test:** Runs JUnit tests
4. **Build Docker Image:** Creates a Docker image of the application
5. **Push Docker Image:** Uploads the image to Docker Hub
6. **Run Ansible Playbook:** Deploys the application using Ansible

## Running the Calculator

After deployment, you can run the calculator using Docker:

```bash
# Pull the latest image
docker pull prabhav49/scientific-calculator

# Run the calculator with arguments
docker run prabhav49/scientific-calculator java -jar app.jar <operation> <num1> <num2>

# Example (for operation 1 with numbers 4 and 2):
docker run prabhav49/scientific-calculator java -jar app.jar 1 4 2

# To interact with a running container
docker exec -it scientific_calculator java -jar app.jar 1 4 2
```

## Troubleshooting

To check the status of the Docker container:
```bash
docker ps -a
docker logs scientific_calculator
```

## Future Enhancements
- Web-based GUI interface for the calculator
- Advanced scientific functions (trigonometric, statistical, etc.)
- Multi-container architecture with microservices
- Kubernetes deployment configuration
- Monitoring and logging with ELK/Prometheus stack

## Contributing
1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create pull request

## License
© 2025 Prabhav Pandey, IIITB. All Rights Reserved.

## Contact
Prabhav Pandey - Prabhav.Pandey@iiitb.ac.in

## Author

Prabhav Pandey (MT2024115)  
International Institute of Information Technology, Bangalore

## References

- [GitHub Repository](https://github.com/Prabhav49/ScientificCalculator)
- [Docker Hub Repository](https://hub.docker.com/r/prabhav49/scientific-calculator)
