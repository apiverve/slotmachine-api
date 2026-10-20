from setuptools import setup, find_packages

setup(
    name='apiverve_slotmachinesimulator',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Slot Machine Simulator generates slot machine reel spins for configurable reels, bet sizes, and spin counts. Every run outputs symbol names and emoji for each reel; paid plans add payout calculations, win tracking, and net profit statistics.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/slotmachine?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
