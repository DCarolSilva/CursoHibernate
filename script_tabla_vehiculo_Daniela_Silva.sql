USE [PRUEBA]
GO

/****** Object:  Table [dbo].[colegio_alumno]    Script Date: 11/11/2022 17:27:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Vehiculo_Daniela_Silva](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[marca] [varchar](100) NOT NULL,
	[modelo] [varchar](100)NOT NULL,
	[color] [varchar](15) NOT NULL,
	[transmision] [varchar](25),
	[anio] int NOT NULL
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO



