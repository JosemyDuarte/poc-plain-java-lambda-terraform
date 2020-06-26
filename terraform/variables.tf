variable "account_id" {
}

variable "region" {
}

variable "lambda_payload_filename" {
  default = "../target/helloworldjava-1.0-SNAPSHOT.jar"
}

variable "lambda_function_handler" {
  default = "io.josemyduarte.helloworld.HelloLambdaHandler"
}

variable "lambda_runtime" {
  default = "java8"
}

variable "lambda_function_name" {
  default = "PlainJavaHelloWorld"
}

variable "api_path" {
  default = "plainhelloworld"
}

variable "hello_world_http_method" {
  default = "POST"
}

variable "api_env_stage_name" {
  default = "beta"
}
