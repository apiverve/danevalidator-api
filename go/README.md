# DANE Record Validator API - Go Client

DANE Record Validator validates DANE/TLSA DNS records used for certificate authentication, providing security analysis and best practice recommendations.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [DANE Record Validator API](https://apiverve.com/marketplace/danevalidator?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/danevalidator-api/go
```

---

## Configuration

Before using the DANE Record Validator API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The DANE Record Validator API documentation is found here: [https://docs.apiverve.com/ref/danevalidator](https://docs.apiverve.com/ref/danevalidator?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/danevalidator-api/go"
)

func main() {
    // Create a new client
    client := danevalidator.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "record": "_443._tcp.example.com. 86400 IN TLSA 3 1 1 0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
