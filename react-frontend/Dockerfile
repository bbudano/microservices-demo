FROM nginx:stable

COPY build /usr/share/nginx/html

EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost || exit 1