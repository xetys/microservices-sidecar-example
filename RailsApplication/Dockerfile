FROM xetys/rails-java
ADD . .
RUN bundle install
CMD rails s -b 0.0.0.0 -d && sh -c 'java -jar bin/sidecar-1.0.jar --side-app-name=cloud-rails --eureka-url=http://eureka:8761/eureka/'
EXPOSE 3000