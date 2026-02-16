# DANE Record Validator API - Dart/Flutter Client

DANE Record Validator validates DANE/TLSA DNS records used for certificate authentication, providing security analysis and best practice recommendations.

[![pub package](https://img.shields.io/pub/v/apiverve_danevalidator.svg)](https://pub.dev/packages/apiverve_danevalidator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_danevalidator: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_danevalidator/apiverve_danevalidator.dart';

void main() async {
  final client = DanevalidatorClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'record': '_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/danevalidator](https://docs.apiverve.com/ref/danevalidator?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
