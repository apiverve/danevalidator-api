using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DANERecordValidator
{
    /// <summary>
    /// Query options for the DANE Record Validator API
    /// </summary>
    public class DANERecordValidatorQueryOptions
    {
        /// <summary>
        /// The DANE/TLSA record string to validate
        /// Example: _443._tcp.example.com. 3600 IN TLSA 3 1 1 abc123...
        /// </summary>
        [JsonProperty("record")]
        public string Record { get; set; }
    }
}
