# [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)

DANE Record Validator validates DANE/TLSA DNS records used for certificate authentication, providing security analysis and best practice recommendations.

The DANE Record Validator API provides a simple, reliable way to integrate dane record validator functionality into your applications. Built for developers who need production-ready dane record validator capabilities without the complexity of building from scratch.

**[View API Details →](https://apiverve.com/marketplace/danevalidator?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API Status](https://img.shields.io/badge/Status-Active-green.svg)](https://apiverve.com/marketplace/danevalidator?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
[![Method](https://img.shields.io/badge/Method-POST-blue.svg)](#)
[![Platform](https://img.shields.io/badge/Platform-Multi--Platform-orange.svg)](#installation)

**Available on:**
[![npm](https://img.shields.io/badge/npm-CB3837?style=flat&logo=npm&logoColor=white)](https://www.npmjs.com/package/@apiverve/danevalidator)
[![NuGet](https://img.shields.io/badge/NuGet-004880?style=flat&logo=nuget&logoColor=white)](https://www.nuget.org/packages/APIVerve.API.DANERecordValidator)
[![PyPI](https://img.shields.io/badge/PyPI-3776AB?style=flat&logo=python&logoColor=white)](https://pypi.org/project/apiverve-danevalidator/)
[![RubyGems](https://img.shields.io/badge/RubyGems-E9573F?style=flat&logo=rubygems&logoColor=white)](https://rubygems.org/gems/apiverve_danevalidator)
[![Packagist](https://img.shields.io/badge/Packagist-F28D1A?style=flat&logo=packagist&logoColor=white)](https://packagist.org/packages/apiverve/danevalidator)
[![Go](https://img.shields.io/badge/Go-00ADD8?style=flat&logo=go&logoColor=white)](#-go)
[![Dart](https://img.shields.io/badge/Dart-0175C2?style=flat&logo=dart&logoColor=white)](https://pub.dev/packages/apiverve_danevalidator)
[![JitPack](https://img.shields.io/badge/JitPack-2E7D32?style=flat&logo=android&logoColor=white)](#-android-jitpack)

---

## Quick Start

### Using JavaScript

```javascript
async function callDANERecordValidatorAPI() {
    try {
        const requestBody = {
    "record": "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF"
};

        const response = await fetch('https://api.apiverve.com/v1/danevalidator', {
            method: 'POST',
            headers: {
                'x-api-key': 'YOUR_API_KEY_HERE',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

callDANERecordValidatorAPI();
```

### Using cURL

```bash
curl -X POST "https://api.apiverve.com/v1/danevalidator" \
  -H "x-api-key: YOUR_API_KEY_HERE" \
  -H "Content-Type: application/json" \
  -d '{
    "record": "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF"
}'
```

**Get your API key:** [https://apiverve.com](https://apiverve.com)

**📁 For more examples, see the [examples folder](./examples/)**

---

## Installation

Choose your preferred programming language:

### 📦 NPM (JavaScript/Node.js)

```bash
npm install @apiverve/danevalidator
```

[**View NPM Package →**](https://www.npmjs.com/package/@apiverve/danevalidator) | [**Package Code →**](./npm/)

---

### 🔷 NuGet (.NET/C#)

```bash
dotnet add package APIVerve.API.DANERecordValidator
```

[**View NuGet Package →**](https://www.nuget.org/packages/APIVerve.API.DANERecordValidator) | [**Package Code →**](./nuget/)

---

### 🐍 Python (PyPI)

```bash
pip install apiverve-danevalidator
```

[**View PyPI Package →**](https://pypi.org/project/apiverve-danevalidator/) | [**Package Code →**](./python/)

---

### 💎 Ruby (RubyGems)

```bash
gem install apiverve_danevalidator
```

[**View RubyGems Package →**](https://rubygems.org/gems/apiverve_danevalidator) | [**Package Code →**](./ruby/)

---

### 🐘 PHP (Packagist)

```bash
composer require apiverve/danevalidator
```

[**View Packagist Package →**](https://packagist.org/packages/apiverve/danevalidator) | [**Package Code →**](./php/)

---

### 🎯 Dart (pub.dev)

```bash
dart pub add apiverve_danevalidator
```

[**View pub.dev Package →**](https://pub.dev/packages/apiverve_danevalidator) | [**Package Code →**](./dart/)

---

### 🤖 Android (JitPack)

```gradle
implementation 'com.github.apiverve:danevalidator-api:1.0.0'
```

[**Package Code →**](./android/)

---

### 🐹 Go

```bash
go get github.com/apiverve/danevalidator-api/go
```

[**Package Code →**](./go/)

---

## Why Use This API?

| Feature | Benefit |
|---------|---------|
| **Multi-language SDKs** | Native packages for JavaScript, Python, C#, Go, and Android |
| **Simple Integration** | Single API key authentication, consistent response format |
| **Production Ready** | 99.9% uptime SLA, served from 24 global regions |
| **Comprehensive Docs** | Full examples, OpenAPI spec, and dedicated support |

---

## Documentation

- 🏠 **API Home:** [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
- 📚 **API Reference:** [docs.apiverve.com/ref/danevalidator](https://docs.apiverve.com/ref/danevalidator)
- 📖 **OpenAPI Spec:** [openapi.yaml](./openapi.yaml)
- 💡 **Examples:** [examples/](./examples/)

---

## What Can You Build?

The DANE Record Validator API is commonly used for:

- **Web Applications** - Add dane record validator features to your frontend or backend
- **Mobile Apps** - Native SDKs for Android development
- **Automation** - Integrate with n8n, Zapier, or custom workflows
- **SaaS Products** - Enhance your product with dane record validator capabilities
- **Data Pipelines** - Process and analyze data at scale

---

## API Reference

### Authentication
All requests require an API key in the header:
```
x-api-key: YOUR_API_KEY_HERE
```

Get your API key: [https://apiverve.com](https://apiverve.com)

### Response Format

Every APIVerve endpoint returns the same envelope — check `status`, then read `data`:

```json
{
  "status": "ok",
  "error": null,
  "data": { ... }
}
```

### Example Response

A real response from the DANE Record Validator API:

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

---

## Support & Community

- 🏠 **API Home**: [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source&#x3D;github&amp;utm_medium&#x3D;readme)
- 💬 **Support**: [https://apiverve.com/contact](https://apiverve.com/contact)
- 🐛 **Issues**: [GitHub Issues](../../issues)
- 📖 **Documentation**: [https://docs.apiverve.com](https://docs.apiverve.com)
- 🌐 **Website**: [https://apiverve.com](https://apiverve.com)

---

## Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## Security

For security concerns, please review our [Security Policy](SECURITY.md).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

Built with ❤️ by [APIVerve](https://apiverve.com)

Copyright © 2026 APIVerve. All rights reserved.
