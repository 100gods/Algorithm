n=int(raw_input());
mod=1000000007;
for i in range(n):
    line= str(raw_input()).split();
    print pow(int(line[0]),int(line[1]),mod)
