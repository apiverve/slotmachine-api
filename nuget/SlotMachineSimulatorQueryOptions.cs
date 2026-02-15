using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.SlotMachineSimulator
{
    /// <summary>
    /// Query options for the Slot Machine Simulator API
    /// </summary>
    public class SlotMachineSimulatorQueryOptions
    {
        /// <summary>
        /// Number of spins to simulate
        /// </summary>
        [JsonProperty("spins")]
        public string Spins { get; set; }

        /// <summary>
        /// Number of reels
        /// </summary>
        [JsonProperty("reels")]
        public string Reels { get; set; }

        /// <summary>
        /// Bet amount per spin
        /// </summary>
        [JsonProperty("bet")]
        public string Bet { get; set; }
    }
}
