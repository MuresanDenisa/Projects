----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/02/2020 04:01:27 PM
-- Design Name: 
-- Module Name: regSRRN - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity regSRRN is
Generic (n: natural);
Port ( D: in STD_LOGIC_VECTOR(n-1 downto 0);
       Q: out STD_LOGIC_VECTOR(n-1 downto 0);
       Clk, CE, RST, Load: in STD_LOGIC;  
       SRI: in STD_LOGIC_VECTOR(3 downto 0));     
end regSRRN;

architecture Behavioral of regSRRN is
signal aux: STD_LOGIC_VECTOR(n-1 downto 0):=(others => '0');
begin
process(Clk)
    begin
    if(rising_edge(Clk)) then
            if(RST='1') then
                aux<= (others => '0');
            elsif (Load='1') then
                aux<=D;     
            elsif(CE='1') then
                aux<=SRI & aux(n-1 downto 4);
            end if;
        end if;
end process;
Q<=aux;
end Behavioral;
