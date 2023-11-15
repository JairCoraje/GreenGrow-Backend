FROM ubuntu:latest
LABEL authors="Piero"

ENTRYPOINT ["top", "-b"]