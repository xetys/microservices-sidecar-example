
Rails.application.config.after_initialize do
  options = Rails::Server.new.options
  appName = Rails.application.class.parent_name

  puts "my host = #{options[:Host]} and port = #{options[:Port]}"
  parameters = {
      :instance => {
        :hostName => options[:Host],
        :app => appName.upcase,
        :vipAddress => appName.downcase,
        :ipAddr => options[:Host],
        :status => 'UP',
        :port => options[:Port],
        :homePageUrl => "http://#{options[:Host]}:#{options[:Port]}/",
        :statusPageUrl => "http://#{options[:Host]}:#{options[:Port]}/",
        :healthCheckUrl => "http://#{options[:Host]}:#{options[:Port]}/",
        :dataCenterInfo => {
            :name => 'MyOwn'
        }
      }
  }

  begin
    puts RestClient.post "http://localhost:8761/eureka/apps/#{appName.downcase}", parameters.to_json, :content_type => :json, :accept => :json
  rescue RestClient::ExceptionWithResponse => err
    puts err.response
  end
end

