USE [master]
GO
/****** Object:  Database [QLshopgiay]    Script Date: 3/27/2020 8:19:31 PM ******/
CREATE DATABASE [QLshopgiay]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLshopgiay', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLshopgiay.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLshopgiay_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\QLshopgiay_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLshopgiay] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLshopgiay].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLshopgiay] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLshopgiay] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLshopgiay] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLshopgiay] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLshopgiay] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLshopgiay] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLshopgiay] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLshopgiay] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLshopgiay] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLshopgiay] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLshopgiay] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLshopgiay] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLshopgiay] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLshopgiay] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLshopgiay] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLshopgiay] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLshopgiay] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLshopgiay] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLshopgiay] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLshopgiay] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLshopgiay] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLshopgiay] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLshopgiay] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLshopgiay] SET  MULTI_USER 
GO
ALTER DATABASE [QLshopgiay] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLshopgiay] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLshopgiay] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLshopgiay] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [QLshopgiay] SET DELAYED_DURABILITY = DISABLED 
GO
USE [QLshopgiay]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NULL,
	[Password] [nvarchar](50) NULL,
	[maxacnhan] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[AccID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CatID] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CatID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetailID]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetailID](
	[OrderDetailID] [int] NOT NULL,
	[Date] [nvarchar](50) NULL,
	[UserID] [int] NULL,
	[ProductID] [int] NULL,
	[Quantity] [int] NULL,
	[Price] [int] NULL,
	[Payment_method] [nvarchar](50) NULL,
	[OrderID] [int] NULL,
 CONSTRAINT [PK_OrderDetailID] PRIMARY KEY CLUSTERED 
(
	[OrderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderKH]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderKH](
	[OrderID] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[UserID] [int] NULL,
	[Price] [int] NULL,
	[Date] [nvarchar](50) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] NOT NULL,
	[NamePr] [nvarchar](50) NULL,
	[Brand] [nvarchar](50) NULL,
	[Price] [int] NULL,
	[Quantity] [int] NULL,
	[Description] [nvarchar](50) NULL,
	[CatID] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserKH]    Script Date: 3/27/2020 8:19:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserKH](
	[UserID] [int] NOT NULL,
	[Fullname] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[Age] [int] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([AccID], [Username], [Password], [maxacnhan]) VALUES (1, N'admin', N'12345', N'12345')
SET IDENTITY_INSERT [dbo].[Account] OFF
INSERT [dbo].[Category] ([CatID], [Name]) VALUES (1, N'Nam')
INSERT [dbo].[Category] ([CatID], [Name]) VALUES (2, N'Nữ')
INSERT [dbo].[OrderDetailID] ([OrderDetailID], [Date], [UserID], [ProductID], [Quantity], [Price], [Payment_method], [OrderID]) VALUES (1, N'23/03/2020', 1, 1, 3, 1500000, N'Trực Tiếp', 1)
INSERT [dbo].[OrderDetailID] ([OrderDetailID], [Date], [UserID], [ProductID], [Quantity], [Price], [Payment_method], [OrderID]) VALUES (2, N'22/03/2020', 2, 2, 2, 4000000, N'Online', 2)
INSERT [dbo].[OrderKH] ([OrderID], [Name], [UserID], [Price], [Date]) VALUES (1, N'Sneaker', 1, 1000000, N'23/03/2020')
INSERT [dbo].[OrderKH] ([OrderID], [Name], [UserID], [Price], [Date]) VALUES (2, N'Deerupt', 2, 2000000, N'22/03/2020')
INSERT [dbo].[Product] ([ProductID], [NamePr], [Brand], [Price], [Quantity], [Description], [CatID]) VALUES (1, N'Sneaker', N'adidas', 1000000, 5, N'39', 1)
INSERT [dbo].[Product] ([ProductID], [NamePr], [Brand], [Price], [Quantity], [Description], [CatID]) VALUES (2, N'Deerupt', N'adidas', 2000000, 2, N'40', 1)
INSERT [dbo].[Product] ([ProductID], [NamePr], [Brand], [Price], [Quantity], [Description], [CatID]) VALUES (3, N'Dunk', N'Nike', 500000, 3, N'37', 2)
INSERT [dbo].[Product] ([ProductID], [NamePr], [Brand], [Price], [Quantity], [Description], [CatID]) VALUES (4, N'Triple S', N'Balenciaga', 10000000, 5, N'40', 1)
INSERT [dbo].[UserKH] ([UserID], [Fullname], [Phone], [Address], [Age]) VALUES (1, N' Sang', N'0123257826', N'Vinh Thanh', 21)
INSERT [dbo].[UserKH] ([UserID], [Fullname], [Phone], [Address], [Age]) VALUES (2, N'An', N'0832743560', N'Sóc Trăng', 20)
INSERT [dbo].[UserKH] ([UserID], [Fullname], [Phone], [Address], [Age]) VALUES (3, N'Tai', N'0356848515', N'Cần Thơ', 20)
INSERT [dbo].[UserKH] ([UserID], [Fullname], [Phone], [Address], [Age]) VALUES (4, N'Thai', N'0862841875', N'Cần Thơ', 21)
ALTER TABLE [dbo].[OrderDetailID]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetailID_OrderKH] FOREIGN KEY([OrderID])
REFERENCES [dbo].[OrderKH] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetailID] CHECK CONSTRAINT [FK_OrderDetailID_OrderKH]
GO
ALTER TABLE [dbo].[OrderDetailID]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetailID_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetailID] CHECK CONSTRAINT [FK_OrderDetailID_Product]
GO
ALTER TABLE [dbo].[OrderDetailID]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetailID_UserKH] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserKH] ([UserID])
GO
ALTER TABLE [dbo].[OrderDetailID] CHECK CONSTRAINT [FK_OrderDetailID_UserKH]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([CatID])
REFERENCES [dbo].[Category] ([CatID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
USE [master]
GO
ALTER DATABASE [QLshopgiay] SET  READ_WRITE 
GO
