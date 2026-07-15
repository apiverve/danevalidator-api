declare module '@apiverve/danevalidator' {
  export interface danevalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface danevalidatorResponse {
    status: string;
    error: string | null;
    data: DANERecordValidatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DANERecordValidatorData {
      rawRecord:      null | string;
      parsed:         Parsed;
      interpretation: Interpretation;
      validation:     Validation;
  }
  
  interface Interpretation {
      usage:          Matching;
      selector:       Matching;
      matching:       Matching;
      securityLevel:  null | string;
      recommendation: null | string;
  }
  
  interface Matching {
      name:            null | string;
      description:     null | string;
      fullDescription: null | string;
  }
  
  interface Parsed {
      name:                  null | string;
      port:                  number | null;
      protocol:              null | string;
      hostname:              null | string;
      ttl:                   number | null;
      class:                 null | string;
      usage:                 number | null;
      selector:              number | null;
      matching:              number | null;
      certificateData:       null | string;
      certificateDataLength: number | null;
  }
  
  interface Validation {
      isValid:                    boolean | null;
      certificateDataFormat:      null | string;
      certificateDataLengthValid: boolean | null;
  }

  export default class danevalidatorWrapper {
    constructor(options: danevalidatorOptions);

    execute(callback: (error: any, data: danevalidatorResponse | null) => void): Promise<danevalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: danevalidatorResponse | null) => void): Promise<danevalidatorResponse>;
    execute(query?: Record<string, any>): Promise<danevalidatorResponse>;
  }
}
