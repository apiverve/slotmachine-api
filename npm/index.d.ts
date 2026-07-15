declare module '@apiverve/slotmachine' {
  export interface slotmachineOptions {
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

  export interface slotmachineResponse {
    status: string;
    error: string | null;
    data: SlotMachineSimulatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface SlotMachineSimulatorData {
      totalSpins:       number | null;
      numReels:         number | null;
      betPerSpin:       number | null;
      spins:            Spin[];
      totalBet:         number | null;
      totalWinnings:    number | null;
      netProfit:        number | null;
      wins:             number | null;
      losses:           number | null;
      winPercentage:    number | null;
      availableSymbols: AvailableSymbol[];
  }
  
  interface AvailableSymbol {
      symbol:           null | string;
      name:             null | string;
      payoutMultiplier: number | null;
  }
  
  interface Spin {
      spinNumber: number | null;
      reels:      Reel[];
      bet:        number | null;
      payout:     number | null;
      winType:    null | string;
      isWin:      boolean | null;
  }
  
  interface Reel {
      symbol: null | string;
      name:   null | string;
  }

  export default class slotmachineWrapper {
    constructor(options: slotmachineOptions);

    execute(callback: (error: any, data: slotmachineResponse | null) => void): Promise<slotmachineResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: slotmachineResponse | null) => void): Promise<slotmachineResponse>;
    execute(query?: Record<string, any>): Promise<slotmachineResponse>;
  }
}
