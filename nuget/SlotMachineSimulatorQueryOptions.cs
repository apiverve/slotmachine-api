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
        /// Number of spins to simulate (1-100, default: 1)
        /// Example: 5
        /// </summary>
        [JsonProperty("spins")]
        public string Spins { get; set; }

        /// <summary>
        /// Number of reels (3-5, default: 3)
        /// Example: 3
        /// </summary>
        [JsonProperty("reels")]
        public string Reels { get; set; }

        /// <summary>
        /// Bet amount per spin (0-1000, default: 1)
        /// Example: 1
        /// </summary>
        [JsonProperty("bet")]
        public string Bet { get; set; }
    }
}
