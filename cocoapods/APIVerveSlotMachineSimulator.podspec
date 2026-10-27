Pod::Spec.new do |s|
  s.name             = 'APIVerveSlotMachineSimulator'
  s.version          = '1.2.3'
  s.summary          = 'Slot Machine Simulator generates slot machine reel spins for configurable reels, bet sizes, and spin counts.'
  s.description      = <<-'DESC'
Slot Machine Simulator generates slot machine reel spins for configurable reels, bet sizes, and spin counts. Every run outputs symbol names and emoji for each reel; paid plans add payout calculations, win tracking, and net profit statistics.

This iOS/macOS SDK provides a convenient way to access the Slot Machine Simulator from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/slotmachine?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/slotmachine-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveSlotMachineSimulator/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
