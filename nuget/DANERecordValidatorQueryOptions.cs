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
        /// </summary>
        [JsonProperty("record")]
        public string Record { get; set; }
    }
}
