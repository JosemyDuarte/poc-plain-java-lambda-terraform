resource "aws_dynamodb_table" "demo-dynamodb-table" {
  name = "GameScores"
  billing_mode = "PROVISIONED"
  read_capacity = 10
  write_capacity = 10
  hash_key = "userId"

  attribute {
    name = "userId"
    type = "S"
  }

  ttl {
    attribute_name = "TimeToExist"
    enabled = false
  }

  tags = {
    Name = "dynamodb-table-1"
    Environment = "test"
  }
}