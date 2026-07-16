# DANE Record Validator API - PHP Package

DANE Record Validator validates DANE/TLSA DNS records used for certificate authentication, providing security analysis and best practice recommendations.

## Installation

Install via Composer:

```bash
composer require apiverve/danevalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Danevalidator\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['record' => '_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Danevalidator\Client;
use APIVerve\Danevalidator\Exceptions\APIException;
use APIVerve\Danevalidator\Exceptions\ValidationException;

try {
    $response = $client->execute(['record' => '_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/danevalidator?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/danevalidator?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/danevalidator?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
