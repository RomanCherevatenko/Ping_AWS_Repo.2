resource "aws_sqs_queue" "Roman-Queue" {
  name = "Roman-Queue"
  max_message_size          = 2048
  message_retention_seconds = 86400
  receive_wait_time_seconds = 10

  tags = {
    Name = "My Amazon Server"
    Owner = "Roman Cherevatenko"
    Project = "Test Project"
  }
}
