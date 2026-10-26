/// Response models for the DANE Record Validator API.

/// API Response wrapper.
class DanevalidatorResponse {
  final String status;
  final dynamic error;
  final DanevalidatorData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  DanevalidatorResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory DanevalidatorResponse.fromJson(Map<String, dynamic> json) => DanevalidatorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DanevalidatorData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the DANE Record Validator API.

class DanevalidatorData {
  String? rawRecord;
  DanevalidatorDataParsed? parsed;
  DanevalidatorDataInterpretation? interpretation;
  DanevalidatorDataValidation? validation;

  DanevalidatorData({
    this.rawRecord,
    this.parsed,
    this.interpretation,
    this.validation,
  });

  factory DanevalidatorData.fromJson(Map<String, dynamic> json) => DanevalidatorData(
      rawRecord: json['raw_record'],
      parsed: json['parsed'] != null ? DanevalidatorDataParsed.fromJson(json['parsed']) : null,
      interpretation: json['interpretation'] != null ? DanevalidatorDataInterpretation.fromJson(json['interpretation']) : null,
      validation: json['validation'] != null ? DanevalidatorDataValidation.fromJson(json['validation']) : null,
    );
}

class DanevalidatorDataParsed {
  String? name;
  num? port;
  String? protocol;
  String? hostname;
  num? ttl;
  String? class;
  num? usage;
  num? selector;
  num? matching;
  String? certificateData;
  num? certificateDataLength;

  DanevalidatorDataParsed({
    this.name,
    this.port,
    this.protocol,
    this.hostname,
    this.ttl,
    this.class,
    this.usage,
    this.selector,
    this.matching,
    this.certificateData,
    this.certificateDataLength,
  });

  factory DanevalidatorDataParsed.fromJson(Map<String, dynamic> json) => DanevalidatorDataParsed(
      name: json['name'],
      port: json['port'],
      protocol: json['protocol'],
      hostname: json['hostname'],
      ttl: json['ttl'],
      class: json['class'],
      usage: json['usage'],
      selector: json['selector'],
      matching: json['matching'],
      certificateData: json['certificate_data'],
      certificateDataLength: json['certificate_data_length'],
    );
}

class DanevalidatorDataInterpretation {
  DanevalidatorDataInterpretationUsage? usage;
  DanevalidatorDataInterpretationSelector? selector;
  DanevalidatorDataInterpretationMatching? matching;
  String? securityLevel;
  String? recommendation;

  DanevalidatorDataInterpretation({
    this.usage,
    this.selector,
    this.matching,
    this.securityLevel,
    this.recommendation,
  });

  factory DanevalidatorDataInterpretation.fromJson(Map<String, dynamic> json) => DanevalidatorDataInterpretation(
      usage: json['usage'] != null ? DanevalidatorDataInterpretationUsage.fromJson(json['usage']) : null,
      selector: json['selector'] != null ? DanevalidatorDataInterpretationSelector.fromJson(json['selector']) : null,
      matching: json['matching'] != null ? DanevalidatorDataInterpretationMatching.fromJson(json['matching']) : null,
      securityLevel: json['security_level'],
      recommendation: json['recommendation'],
    );
}

class DanevalidatorDataInterpretationUsage {
  String? name;
  String? description;
  String? fullDescription;

  DanevalidatorDataInterpretationUsage({
    this.name,
    this.description,
    this.fullDescription,
  });

  factory DanevalidatorDataInterpretationUsage.fromJson(Map<String, dynamic> json) => DanevalidatorDataInterpretationUsage(
      name: json['name'],
      description: json['description'],
      fullDescription: json['full_description'],
    );
}

class DanevalidatorDataInterpretationSelector {
  String? name;
  String? description;
  String? fullDescription;

  DanevalidatorDataInterpretationSelector({
    this.name,
    this.description,
    this.fullDescription,
  });

  factory DanevalidatorDataInterpretationSelector.fromJson(Map<String, dynamic> json) => DanevalidatorDataInterpretationSelector(
      name: json['name'],
      description: json['description'],
      fullDescription: json['full_description'],
    );
}

class DanevalidatorDataInterpretationMatching {
  String? name;
  String? description;
  String? fullDescription;

  DanevalidatorDataInterpretationMatching({
    this.name,
    this.description,
    this.fullDescription,
  });

  factory DanevalidatorDataInterpretationMatching.fromJson(Map<String, dynamic> json) => DanevalidatorDataInterpretationMatching(
      name: json['name'],
      description: json['description'],
      fullDescription: json['full_description'],
    );
}

class DanevalidatorDataValidation {
  bool? isValid;
  String? certificateDataFormat;
  bool? certificateDataLengthValid;

  DanevalidatorDataValidation({
    this.isValid,
    this.certificateDataFormat,
    this.certificateDataLengthValid,
  });

  factory DanevalidatorDataValidation.fromJson(Map<String, dynamic> json) => DanevalidatorDataValidation(
      isValid: json['is_valid'],
      certificateDataFormat: json['certificate_data_format'],
      certificateDataLengthValid: json['certificate_data_length_valid'],
    );
}

class DanevalidatorRequest {
  String record;

  DanevalidatorRequest({
    required this.record,
  });

  Map<String, dynamic> toJson() => {
      'record': record,
    };
}
