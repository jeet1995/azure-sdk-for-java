#!/bin/bash
set -e
KEY='ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQCyS+juqrjjjeKQxw0PbjpxnbTStOyY4gPKh7FeflgEPJ7pq6Q2/XMlFT+gBaxM/SjNc2Z0hVGiFrMPEq9Q+6uQhycjboB687Mnbsv9Ayns9xR+B+5hBb1KmAypCXhZH4Ocz18KKK/+l/GXBqSG7DOTkJ/6o/6xd9aaTcSI10WCCnqpwnBVeWoMhETEFsihJTwMPPMJ5iBql/q1L/KRSzZi5Mcpt3mEesyy1ktKqB6DjhBOzVDx3vgF7p/MQsmpoh0VLO/HHEBa2z1KjMcBVXVEhz7hAQssljdkjkJvI0Z0b5U1BlUAVF0eF/akax5F0kOKhLL+6wTdiUcsU4yT7I8b/M5TPtN+xQBX7m6fpaQ4WtVrlSYEiTdM2qmV3TK135t6J5ye2OX/u4+BIG2+EoXjAMpubVqE8WtedONh0ZVvipIybybt8C2tUPWaYk6ZyrPwVzC91TwixGuO8+1bO+l+ZUHwkVsQfOSTCwBy/2W56UB+bU0Zcvmvw+Wwoe8s5VSjgBRusEDScaqh7xf7oEISMMKu+vyg3d6+BNbWWKD5ZCV9dUm+X6w1LiiQ6h/woo0n5UMVQma3USTgg44AtHH2Vfz4NWajjbyvM090nKjZ911jaeme3MfjItCwmexmU0Ej6fTXvkE0rxRuNnnWBXCh6q8iaQfj6EbGmCeRXHdGdQ== redmond\abhmohanty@Jeet-Thinkpad'
mkdir -p /home/azureuser/.ssh
touch /home/azureuser/.ssh/authorized_keys
grep -qF "$KEY" /home/azureuser/.ssh/authorized_keys || echo "$KEY" >> /home/azureuser/.ssh/authorized_keys
chown -R azureuser:azureuser /home/azureuser/.ssh
chmod 700 /home/azureuser/.ssh
chmod 600 /home/azureuser/.ssh/authorized_keys
echo "KEY_LINES=$(wc -l < /home/azureuser/.ssh/authorized_keys)"
echo "ADDKEY_DONE"
