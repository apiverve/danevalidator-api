declare module '@apiverve/danevalidator' {
  export interface danevalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface danevalidatorResponse {
    status: string;
    error: string | null;
    data: DANERecordValidatorData;
    code?: number;
  }


  interface DANERecordValidatorData {
      rawRecord:      string;
      parsed:         Parsed;
      interpretation: Interpretation;
      validation:     Validation;
  }
  
  interface Interpretation {
      usage:          Matching;
      selector:       Matching;
      matching:       Matching;
      securityLevel:  string;
      recommendation: string;
  }
  
  interface Matching {
      name:            string;
      description:     string;
      fullDescription: string;
  }
  
  interface Parsed {
      name:                  string;
      port:                  number;
      protocol:              string;
      hostname:              string;
      ttl:                   number;
      class:                 string;
      usage:                 number;
      selector:              number;
      matching:              number;
      certificateData:       string;
      certificateDataLength: number;
  }
  
  interface Validation {
      isValid:                    boolean;
      certificateDataFormat:      string;
      certificateDataLengthValid: boolean;
  }

  export default class danevalidatorWrapper {
    constructor(options: danevalidatorOptions);

    execute(callback: (error: any, data: danevalidatorResponse | null) => void): Promise<danevalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: danevalidatorResponse | null) => void): Promise<danevalidatorResponse>;
    execute(query?: Record<string, any>): Promise<danevalidatorResponse>;
  }
}
