/// Response models for the Slot Machine Simulator API.

/// API Response wrapper.
class SlotmachineResponse {
  final String status;
  final dynamic error;
  final SlotmachineData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  SlotmachineResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory SlotmachineResponse.fromJson(Map<String, dynamic> json) => SlotmachineResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? SlotmachineData.fromJson(json['data']) : null,
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

/// Response data for the Slot Machine Simulator API.

class SlotmachineData {
  num? totalSpins;
  num? numReels;
  num? betPerSpin;
  List<SlotmachineDataSpinsItem>? spins;
  num? totalBet;
  num? totalWinnings;
  num? netProfit;
  num? wins;
  num? losses;
  num? winPercentage;
  List<SlotmachineDataAvailableSymbolsItem>? availableSymbols;

  SlotmachineData({
    this.totalSpins,
    this.numReels,
    this.betPerSpin,
    this.spins,
    this.totalBet,
    this.totalWinnings,
    this.netProfit,
    this.wins,
    this.losses,
    this.winPercentage,
    this.availableSymbols,
  });

  factory SlotmachineData.fromJson(Map<String, dynamic> json) => SlotmachineData(
      totalSpins: json['total_spins'],
      numReels: json['num_reels'],
      betPerSpin: json['bet_per_spin'],
      spins: (json['spins'] as List?)?.map((e) => SlotmachineDataSpinsItem.fromJson(e)).toList(),
      totalBet: json['total_bet'],
      totalWinnings: json['total_winnings'],
      netProfit: json['net_profit'],
      wins: json['wins'],
      losses: json['losses'],
      winPercentage: json['win_percentage'],
      availableSymbols: (json['available_symbols'] as List?)?.map((e) => SlotmachineDataAvailableSymbolsItem.fromJson(e)).toList(),
    );
}

class SlotmachineDataSpinsItem {
  num? spinNumber;
  List<SlotmachineDataSpinsItemReelsItem>? reels;
  num? bet;
  num? payout;
  String? winType;
  bool? isWin;

  SlotmachineDataSpinsItem({
    this.spinNumber,
    this.reels,
    this.bet,
    this.payout,
    this.winType,
    this.isWin,
  });

  factory SlotmachineDataSpinsItem.fromJson(Map<String, dynamic> json) => SlotmachineDataSpinsItem(
      spinNumber: json['spin_number'],
      reels: (json['reels'] as List?)?.map((e) => SlotmachineDataSpinsItemReelsItem.fromJson(e)).toList(),
      bet: json['bet'],
      payout: json['payout'],
      winType: json['win_type'],
      isWin: json['is_win'],
    );
}

class SlotmachineDataSpinsItemReelsItem {
  String? symbol;
  String? name;

  SlotmachineDataSpinsItemReelsItem({
    this.symbol,
    this.name,
  });

  factory SlotmachineDataSpinsItemReelsItem.fromJson(Map<String, dynamic> json) => SlotmachineDataSpinsItemReelsItem(
      symbol: json['symbol'],
      name: json['name'],
    );
}

class SlotmachineDataAvailableSymbolsItem {
  String? symbol;
  String? name;
  num? payoutMultiplier;

  SlotmachineDataAvailableSymbolsItem({
    this.symbol,
    this.name,
    this.payoutMultiplier,
  });

  factory SlotmachineDataAvailableSymbolsItem.fromJson(Map<String, dynamic> json) => SlotmachineDataAvailableSymbolsItem(
      symbol: json['symbol'],
      name: json['name'],
      payoutMultiplier: json['payout_multiplier'],
    );
}

class SlotmachineRequest {
  int? spins;
  int? reels;
  double? bet;

  SlotmachineRequest({
    this.spins,
    this.reels,
    this.bet,
  });

  Map<String, dynamic> toJson() => {
      if (spins != null) 'spins': spins,
      if (reels != null) 'reels': reels,
      if (bet != null) 'bet': bet,
    };
}
