docker-build:
    @docker build . -t guilhermeklm/feednac-api:$(VERSION)

docker-image-tag:
    @docker image tag guilhermeklm/feednac-api:$(VERSION) guilhermeklm/feednac-api:latest

docker-image-push:
    @docker image push guilhermeklm/feednac-api:$(VERSION)
    @docker image push guilhermeklm/feednac-api:latest

