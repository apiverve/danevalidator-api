# DANE Record Validator API - Ruby Gem

DANE Record Validator validates DANE/TLSA DNS records used for certificate authentication, providing security analysis and best practice recommendations.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_danevalidator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_danevalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_danevalidator'

# Initialize the client
client = APIVerve::Danevalidator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ record: "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ record: "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF" })
  puts response["data"]
rescue APIVerve::Danevalidator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Danevalidator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Danevalidator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "raw_record": "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF",
    "parsed": {
      "name": "_443._tcp.example.com.",
      "port": 443,
      "protocol": "tcp",
      "hostname": "example.com",
      "ttl": 86400,
      "class": "IN",
      "usage": 3,
      "selector": 1,
      "matching": 1,
      "certificate_data": "0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF",
      "certificate_data_length": 64
    },
    "interpretation": {
      "usage": {
        "name": "DANE-EE",
        "description": "Domain-issued certificate",
        "full_description": "Certificate must exactly match the provided association data (most common)"
      },
      "selector": {
        "name": "SPKI",
        "description": "SubjectPublicKeyInfo",
        "full_description": "Match against the Subject Public Key Info (recommended)"
      },
      "matching": {
        "name": "SHA-256",
        "description": "SHA-256 hash",
        "full_description": "SHA-256 hash of the selected content (recommended)"
      },
      "security_level": "Recommended",
      "recommendation": "This is the recommended DANE configuration (DANE-EE + SPKI + SHA-256)"
    },
    "validation": {
      "is_valid": true,
      "certificate_data_format": "Valid hexadecimal",
      "certificate_data_length_valid": true
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/danevalidator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/danevalidator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/danevalidator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
