from setuptools import setup, find_packages

setup(
    name='apiverve_slotmachinesimulator',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Slot Machine Simulator is a tool for simulating slot machine spins with realistic reel symbols and payout calculations. It supports customizable number of reels, bet amounts, and multiple spins with detailed win/loss statistics.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
